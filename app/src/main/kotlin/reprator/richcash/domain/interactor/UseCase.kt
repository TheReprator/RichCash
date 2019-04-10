package reprator.richcash.domain.interactor

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

abstract class UseCase<out Type, in Params> {

    private var job: Deferred<Result<Type>>? = null

    abstract suspend fun run(params: Params): Result<Type>

    fun execute(mCoroutineScope: CoroutineScope,
        params: Params, onResult: (Result<Type>) -> Unit
    ) {
        job?.cancel()
        job = mCoroutineScope.async(Dispatchers.IO) { run(params) }
        mCoroutineScope.launch(Main) {
            val result = job!!.await()
            onResult(result)
        }
    }

    open fun cancel() {
        job?.cancel()
    }

    open class NoParams
}

package reprator.richcash.utils


import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.doTransaction(actions: FragmentTransaction.() -> FragmentTransaction) = beginTransaction().actions().commit()
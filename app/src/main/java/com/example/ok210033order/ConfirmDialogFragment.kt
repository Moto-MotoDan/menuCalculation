package com.example.ok210033order

    import android.app.Dialog
    import android.content.DialogInterface
    import android.os.Bundle
    import android.view.View
    import android.widget.Button
    import android.widget.Toast
    import androidx.appcompat.app.AlertDialog
    import androidx.fragment.app.DialogFragment

    class ConfirmDialogFlagment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val dialog = activity?.let {

                val builder = AlertDialog.Builder(it)

                builder.setTitle(R.string.dialog_title)

                builder.setMessage(R.string.dialog_msg)

                builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())

                builder.create()
            }
            return dialog ?: throw IllegalStateException("アクティビティがnullです")
        }

        private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, which: Int) {

                var msg = ""

                when (which) {

                    DialogInterface.BUTTON_POSITIVE ->

                        msg = getString(R.string.dialog_ok_toast)
                }
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            }
        }
    }

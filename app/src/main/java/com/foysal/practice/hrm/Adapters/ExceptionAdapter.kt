package com.foysal.practice.hrm.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.Model.UserWithExceptions
import com.foysal.practice.hrm.R
import com.foysal.practice.hrm.View.ApproveException
import com.foysal.practice.hrm.View.ExceptionAuthorizeActivity

class ExceptionAdapter(private val activity : ExceptionAuthorizeActivity) :
    RecyclerView.Adapter<ExceptionAdapter.ExceptionViewHolder>(){

    var exceptions : List<Exceptions> = ArrayList()

    class ExceptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textViewId : TextView = itemView.findViewById(R.id.tv_card_id)
        val textViewName : TextView = itemView.findViewById(R.id.tv_card_name)
        val textViewStatus : TextView = itemView.findViewById(R.id.tv_card_status)
        val cardView : CardView = itemView.findViewById(R.id.card_view)
        val authName : TextView = itemView.findViewById(R.id.tv_auth_name)
        val authType : TextView = itemView.findViewById(R.id.tv_auth_type)
        val authStatus : TextView = itemView.findViewById(R.id.tv_auth_status)
        val authReason : TextView = itemView.findViewById(R.id.tv_auth_reason)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExceptionViewHolder {

        val view : View = LayoutInflater.from(parent.context).
        inflate(R.layout.card_design,parent,false)

        return ExceptionViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExceptionViewHolder, position: Int) {

        var currentException : Exceptions = exceptions[position]

        holder.textViewName.text = currentException.name
        holder.textViewId.text = currentException.id.toString()
        holder.authReason.text = currentException.reason
        holder.textViewStatus.text = currentException.status

        holder.cardView.setOnClickListener{

            val intent = Intent(activity, ApproveException::
            class.java)

            intent.putExtra("textViewName", currentException.name)
            intent.putExtra("textViewId", currentException.id)
            intent.putExtra("textViewStatus", currentException.status)
            intent.putExtra("authReason", currentException.reason)
            intent.putExtra("date", currentException.date)
            intent.putExtra("dateType", currentException.dateType)
            intent.putExtra("userId", currentException.userId)

            activity.editActivityResultLauncher.launch(intent)

        }

    }

    override fun getItemCount(): Int {
        return exceptions.size
    }
    fun setException(exceptions : List<Exceptions>){

        this.exceptions = exceptions
        notifyDataSetChanged()

    }

    fun getException(position : Int) : Exceptions{

        return exceptions[position]

    }

}
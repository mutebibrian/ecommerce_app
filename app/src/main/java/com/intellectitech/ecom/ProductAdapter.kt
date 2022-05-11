package com.intellectitech.ecom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.String


class ProductAdapter(
    //this context we will use to inflate the layout
    private val mCtx: Context,
    productList: List<Product>
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    //we are storing all the products in a list
    private val productList: List<Product>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        //inflating and returning our view holder
        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.products, null)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        //getting the product of the specified position
        val product: Product = productList[position]

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.title)
        holder.textViewShortDesc.setText(product.shortdesc)
        holder.textViewRating.setText(String.valueOf(product.rating))
        holder.textViewPrice.setText(String.valueOf(product.price))
        holder.imageView.setImageDrawable(mCtx.resources.getDrawable(product.image))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView
        var textViewShortDesc: TextView
        var textViewRating: TextView
        var textViewPrice: TextView
        var imageView: ImageView

        init {
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc)
            textViewRating = itemView.findViewById(R.id.textViewRating)
            textViewPrice = itemView.findViewById(R.id.textViewPrice)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    //getting the context and product list with constructor
    init {
        this.productList = productList
    }
}
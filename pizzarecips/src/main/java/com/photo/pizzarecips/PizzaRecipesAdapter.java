package com.photo.pizzarecips;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PizzaRecipesAdapter extends RecyclerView.Adapter<PizzaRecipesAdapter.PicaRecipesViewHolder> {
ArrayList<PizzaRecipesItem>pizzaRecipesItems;
Context context;
    public PizzaRecipesAdapter(ArrayList<PizzaRecipesItem> pizzaRecipesItems,Context context) {
        this.pizzaRecipesItems = pizzaRecipesItems;
        this.context=context;

    }

    @NonNull
    @Override
    public PicaRecipesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pizza_recipe_item, viewGroup, false);

    PicaRecipesViewHolder picaRecipesViewHolder=new PicaRecipesViewHolder(view);
    return picaRecipesViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull PicaRecipesViewHolder picaRecipesViewHolder, int i) {
PizzaRecipesItem pizzaRecipesItem=pizzaRecipesItems.get(i);
picaRecipesViewHolder.title.setText(pizzaRecipesItem.getTitle());
picaRecipesViewHolder.pizzaImageView.setImageResource(pizzaRecipesItem.getImageRecours());
picaRecipesViewHolder.decsreption.setText(pizzaRecipesItem.getRecipe());
    }

    @Override
    public int getItemCount() {
        return pizzaRecipesItems.size();
    }

   class  PicaRecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView pizzaImageView;
        public TextView title;
        public TextView decsreption;
        public PicaRecipesViewHolder(@NonNull View itemView) {
            super(itemView);
            //sexmelu knopken e
itemView.setOnClickListener(this);
            pizzaImageView=itemView.findViewById(R.id.pizzaImageView);
            title=itemView.findViewById(R.id.titleImageView);
            decsreption=itemView.findViewById(R.id.descreptionImageView);
        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            PizzaRecipesItem pizzaRecipesItem=pizzaRecipesItems.get(position);

            Intent intent=new Intent(context,RecipeActivity.class);
intent.putExtra("imageResours",pizzaRecipesItem.getImageRecours());
intent.putExtra("title",pizzaRecipesItem.getTitle());
intent.putExtra("decreption",pizzaRecipesItem.getDecreption());


            context.startActivity(intent);

        }
    }
}

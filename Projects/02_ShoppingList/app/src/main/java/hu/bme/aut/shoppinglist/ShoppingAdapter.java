package hu.bme.aut.shoppinglist;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Neo on 10/10/2016.
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    private final List<ShoppingItem> items;

    public ShoppingAdapter() {
        items = new ArrayList<>();
    }

    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shopping_list, parent, false);
        ShoppingViewHolder viewHolder = new
                ShoppingViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShoppingViewHolder holder, int position) {
        ShoppingItem item = items.get(position);
        holder.nameTextView.setText(item.name);
        holder.descriptionTextView.setText(item.description);
        holder.categoryTextView.setText(item.category.name());
        holder.priceTextView.setText(item.estimatedPrice + " Ft");
        holder.iconImageView.setImageResource(getImageResource(item.category));
        holder.isBoughtCheckBox.setChecked(item.isBought);

        holder.isBoughtCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = holder.isBoughtCheckBox.isChecked();
                Log.d(TAG, "onClick: checked = " + checked + " in position " + holder.getAdapterPosition());
                ShoppingItem item = items.get(holder.getAdapterPosition());
                item.isBought = checked;
                item.save();
            }
        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(holder.getAdapterPosition());
            }
        });
    }

    private
    @DrawableRes
    int getImageResource(ShoppingItem.Category category) {
        @DrawableRes int ret;
        switch (category) {
            case BOOK:
                ret = R.drawable.open_book;
                break;
            case ELECTRONIC:
                ret = R.drawable.lightning;
                break;
            case FOOD:
                ret = R.drawable.groceries;
                break;
            default:
                ret = 0;
        }
        return ret;
    }

    public void addItem(ShoppingItem item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void update(List<ShoppingItem> shoppingItems) {
        items.clear();
        items.addAll(shoppingItems);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        ShoppingItem removed = items.remove(position);
        removed.delete();
        notifyItemRemoved(position);
        if (position < items.size()) {
            notifyItemRangeChanged(position, items.size() - position);
        }
    }

    public void removeAllItems() {
        for(ShoppingItem item : items) {
            item.delete();
        }
        int count = items.size();
        items.clear();
        notifyItemRangeRemoved(0, count);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ShoppingViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView categoryTextView;
        TextView priceTextView;
        CheckBox isBoughtCheckBox;
        ImageButton removeButton;

        int position;

        public ShoppingViewHolder(View itemView) {
            super(itemView);
            iconImageView = (ImageView) itemView.findViewById(R.id.ShoppingItemIconImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.ShoppingItemNameTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.ShoppingItemDescriptionTextView);
            categoryTextView = (TextView) itemView.findViewById(R.id.ShoppingItemCategoryTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.ShoppingItemPriceTextView);
            isBoughtCheckBox = (CheckBox) itemView.findViewById(R.id.ShoppingItemIsBoughtCheckBox);
            removeButton = (ImageButton) itemView.findViewById(R.id.ShoppingItemRemoveButton);
        }
    }
}

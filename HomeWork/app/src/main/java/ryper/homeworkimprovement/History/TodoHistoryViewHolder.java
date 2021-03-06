package ryper.homeworkimprovement.History;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ryper.homeworkimprovement.R;


/**
 * Created by Ryper on 2016. 10. 22..
 */
public class TodoHistoryViewHolder extends RecyclerView.ViewHolder {
    int position;
    TextView nameTextView;
    TextView dateStartTextView;
    TextView dateEndTextView;

    public TodoHistoryViewHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.TodoListItemDesc);

        dateStartTextView = (TextView) itemView.findViewById(R.id.TodoListItemStartDate);
        dateEndTextView = (TextView) itemView.findViewById(R.id.TodoListItemEndDate);

        //Disable buttons
        Button completeButton = (Button) itemView.findViewById(R.id.TodoListItemCompleteBtn);
        Button removeButton = (Button) itemView.findViewById(R.id.TodoListItemRemovBtn);
        completeButton.setVisibility(View.GONE);
        removeButton.setVisibility(View.GONE);
    }
}

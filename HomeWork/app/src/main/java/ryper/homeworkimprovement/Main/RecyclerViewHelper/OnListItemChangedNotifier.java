package ryper.homeworkimprovement.Main.RecyclerViewHelper;

/**
 * Created by Ryper on 2016. 11. 04..
 */
public interface OnListItemChangedNotifier {
    void ItemCompleted(int position);
    void ItemRemoved(int position);
}

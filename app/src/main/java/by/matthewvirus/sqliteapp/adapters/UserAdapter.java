package by.matthewvirus.sqliteapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import by.matthewvirus.sqliteapp.R;
import by.matthewvirus.sqliteapp.model.entities.UserModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    public interface OnUserClickListener {
        void onUserClick(UserModel user, int position);
    }

    private final OnUserClickListener onUserClickListener;
    private final LayoutInflater inflater;
    private final List<UserModel> users;

    public UserAdapter(
            Context context,
            List<UserModel> users,
            OnUserClickListener onUserClickListener
    ) {
        this.onUserClickListener = onUserClickListener;
        this.inflater = LayoutInflater.from(context);
        this.users = users;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.users_list_item, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        UserModel user = users.get(position);

        holder.userNameTextView.setText(user.username);

        holder.itemView.setOnClickListener(view -> onUserClickListener.onUserClick(user, position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        public final TextView userNameTextView;

        UserHolder(View view) {
            super(view);
            userNameTextView = view.findViewById(R.id.user_name_item_text);

        }
    }

}
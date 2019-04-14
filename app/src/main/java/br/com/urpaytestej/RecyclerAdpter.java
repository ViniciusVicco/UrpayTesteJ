//package br.com.urpaytestej;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//
//public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerAdpter.ViewHolder> {
//
//    private ArrayList<String> mPokemon = new ArrayList<>();
//    private Context mContext;
//    private final onClickPokemon listener;
//
//
//    public RecyclerAdpter(Context context, ArrayList<String> mPokemon, onClickPokemon listener) {
//        this.mPokemon = mPokemon;
//        this.mContext = context;
//        this.listener = listener;
//    }
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//
//
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mPokemon.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//
//
//
//        public ViewHolder(final View itemView) {
//            super(itemView);
//
//        }
//
//
//
//    }
//
//}

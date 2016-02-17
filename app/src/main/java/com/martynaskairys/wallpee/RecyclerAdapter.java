package com.martynaskairys.wallpee;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Single Responsibility:
 *
 * Populates GridView in MainActivity
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

	private String[] imageUrls;
	private Context context;

	public RecyclerAdapter(Context context) {
		this.context = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		Picasso.with(context)
				.load(imageUrls[position])
				.placeholder(R.drawable.mok)
				.into(holder.imageView);

		holder.imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String url = imageUrls[position];

				Intent intent = new Intent(context, PictureActivity.class);
				intent.putExtra(PictureActivity.PICTURE, url);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //not recommended?
				context.startActivity(intent);


			}
		});
	}

	@Override
	public int getItemCount() {
		return imageUrls.length;
	}

	class ViewHolder extends RecyclerView.ViewHolder {
		ImageView imageView;

		ViewHolder(View itemView) {
			super(itemView);
			imageView = (ImageView) itemView.findViewById(R.id.image_view);

		}
	}

	/** Sets data to display by this adapter */
	void setData(@Nullable String[] images) {
		imageUrls = images;
		notifyDataSetChanged();
	}

}

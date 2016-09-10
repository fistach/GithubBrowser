package pl.training.githubbrowser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fist on 2016-09-10.
 */
public class User implements Parcelable {

	private long id;
	private String name;
	private String url;
	private String email;
	private String login;
	private String location;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}
}

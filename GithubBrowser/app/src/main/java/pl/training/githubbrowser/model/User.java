package pl.training.githubbrowser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fist on 2016-09-10.
 */
public class User implements Parcelable {

	private long id;
	public String name;
	public String url;
	public String email;
	private String login;
	public String location;

	@SerializedName("avatar_url")
	public String avatarUrl;

	protected User(Parcel in) {
		id = in.readLong();
		name = in.readString();
		url = in.readString();
		email = in.readString();
		login = in.readString();
		location = in.readString();
		avatarUrl = in.readString();
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		@Override
		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(id);
		dest.writeString(name);
		dest.writeString(url);
		dest.writeString(email);
		dest.writeString(login);
		dest.writeString(location);
		dest.writeString(avatarUrl);
	}

	public boolean hasEmail() {
		return email != null && !email.isEmpty();
	}

	public boolean hasLocation() {
		return location != null && !location.isEmpty();
	}

}

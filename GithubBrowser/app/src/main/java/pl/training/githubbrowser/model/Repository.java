package pl.training.githubbrowser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fist on 2016-09-10.
 */
public class Repository implements Parcelable {

	long id;
	public String name;
	public String description;
	@SerializedName("stargazers_count")
	public
	int stars;
	String language;
	String homepage;
	User owner;
	public int forks;
	public int watchers;

	protected Repository(Parcel in) {
		id = in.readLong();
		name = in.readString();
		description = in.readString();
		forks = in.readInt();
		watchers = in.readInt();
		stars = in.readInt();
		language = in.readString();
		homepage = in.readString();
		owner = in.readParcelable(User.class.getClassLoader());
	}

	public static final Creator<Repository> CREATOR = new Creator<Repository>() {
		@Override
		public Repository createFromParcel(Parcel in) {
			return new Repository(in);
		}

		@Override
		public Repository[] newArray(int size) {
			return new Repository[size];
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
		dest.writeString(description);
		dest.writeInt(forks);
		dest.writeInt(watchers);
		dest.writeInt(stars);
		dest.writeString(language);
		dest.writeString(homepage);
		dest.writeParcelable(owner, flags);
	}
}

package com.ting.androidexample.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author tingzi [zhangjieting@gmail.com]
 *
 */
public class ParcelableDemo implements Parcelable {

	private ParcelableDemo(Parcel source) {
		
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		
	}
	
	public static final Parcelable.Creator<ParcelableDemo> CREATOR
    		= new Parcelable.Creator<ParcelableDemo>() {

		@Override
		public ParcelableDemo createFromParcel(Parcel source) {
			return new ParcelableDemo(source);
		}

		@Override
		public ParcelableDemo[] newArray(int size) {
			return new ParcelableDemo[size];
		}

};

}

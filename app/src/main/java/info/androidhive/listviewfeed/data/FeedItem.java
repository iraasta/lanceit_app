package info.androidhive.listviewfeed.data;

import com.google.android.gms.maps.model.LatLng;

public class FeedItem {
	private String id;
	private String title, username, description;
	private long timeStamp;
	private LatLng latLng;
	private int expireIn;


    //Fast fix, no time for cocking around...
    private double lat;
    private double lng;

	public FeedItem() {
	}

	public FeedItem(String id,String username, String title, String description,
			String profilePic, long timeStamp) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.description = description;
		this.timeStamp = timeStamp;
	}

	public String getId() {
		return id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setExpiration(int expireIn) {
		this.expireIn = expireIn;
	}

	public void setLatLng(String lat, String lng) {
		this.latLng = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
        this.lat = Double.parseDouble(lat);
        this.lng = Double.parseDouble(lng);

	}

	public long getExpiration() {
		return this.expireIn*1000*60 + timeStamp;
	}

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}

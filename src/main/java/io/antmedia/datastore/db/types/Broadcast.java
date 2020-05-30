package io.antmedia.datastore.db.types;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="Broadcast", description="The basic broadcast class")
@Entity(value = "broadcast", noClassnameStored = true)
@Indexes({ @Index(fields = @Field("name")), @Index(fields = @Field("streamId")) })
public class Broadcast {


	@JsonIgnore
	@Id
	private ObjectId dbId;

	/**
	 * id of the broadcast
	 */
	@ApiModelProperty(value = "the id of the stream")
	private String streamId;

	/**
	 * "finished", "broadcasting", "created"
	 */
	
	@ApiModelProperty(value = "the status of the stream", allowableValues = "finished, broadcasting,created")
	private String status;

	/**
	 * "liveStream", "ipCamera", "streamSource", "VoD"
	 */
	@ApiModelProperty(value = "the type of the stream", allowableValues = "liveStream, ipCamera,streamSource,VoD")
	private String type;

	/**
	 * name of the broadcast
	 */
	@ApiModelProperty(value = "the name of the stream")
	private String name;

	/**
	 * description of the broadcast
	 */
	@ApiModelProperty(value = "the description of the stream")
	private String description;

	/**
	 * It is a video filter for the service, this value is controlled by the
	 * user, default value is true in the db
	 */
	@ApiModelProperty(value = "it is a video filter for the service, this value is controlled by the user, default value is true in the db")
	private boolean publish = true;

	/**
	 * date when record is created in milliseconds
	 */
	@ApiModelProperty(value = "the date when record is created in milliseconds")
	private Long date;

	/**
	 * Planned start date in milliseconds
	 */
	@ApiModelProperty(value = "the planned start date")
	private Long plannedStartDate;
	
	/**
	 * Planned end date in milliseconds
	 */
	@ApiModelProperty(value = "the planned end date")
	private Long plannedEndDate;

	/**
	 * duration of the stream in milliseconds
	 */
	@ApiModelProperty(value = "the duration of the stream in milliseconds")
	private Long duration;

	@ApiModelProperty(value = "the list of endpoints such as Facebook, Twitter or custom RTMP endpoints  ")
	@Embedded
	private List<Endpoint> endPointList;

	/**
	 * is public
	 */
	@ApiModelProperty(value = "the identifier of whether stream is public or not")
	private boolean publicStream = true;

	/**
	 * If this stream is a 360 degree video
	 */
	@ApiModelProperty(value = "the identifier of whether stream is 360 or not")
	private boolean is360 = false;

	/**
	 * This is the url that will be notified when stream is published, ended and
	 * muxing finished
	 * 
	 * It sends some variables with POST UrlEncodedForm
	 * 
	 * variables are "id" mandatory This is the id of the broadcast
	 * 
	 * "action" mandatory This parameter defines what happened. Values can be
	 * "liveStreamStarted" this parameter is sent when stream is started
	 * 
	 * "liveStreamEnded" this parameter is sent when stream is finished
	 * 
	 * "vodReady" this parameter is sent when vod(mp4) file ready. It is
	 * typically a few seconds later after "liveStreamEnded"
	 * 
	 * 
	 * "vodName" It is sent with "vodReady" action. This is the name of the file
	 * physicall recorded file
	 * 
	 * "streamName" optional It is sent with above parameters if stream name
	 * exists
	 * 
	 * "category" optional It is sent if category exists
	 * 
	 */
	
	@ApiModelProperty(value = "the url that will be notified when stream is published, ended and muxing finished")
	private String listenerHookURL;

	@ApiModelProperty(value = "the category of the stream")
	private String category;
	
	@ApiModelProperty(value = "the IP Address of the IP Cameraor publisher")
	private String ipAddr;
	
	@ApiModelProperty(value = "the user name of the IP Camera")
	private String username;
	
	@ApiModelProperty(value = "the password of the IP Camera")
	private String password;

	@ApiModelProperty(value = "the quality of the incoming stream during publishing")
	private String quality;
	
	@ApiModelProperty(value = "the speed of the incoming stream, for better quality and performance it should be around 1.00")
	private double speed;
	
	/**
	 * This is the stream url for fetching stream. 
	 * It has a value for IPCameras and streams in the cloud
	 */
	@ApiModelProperty(value = "the stream URL for fetching stream, especially should be defined for IP Cameras or Cloud streams")
	private String streamUrl;

	/**
	 * This is the origin address server broadcasting. 
	 */
	@ApiModelProperty(value = "the origin address server broadcasting")
	private String originAdress;
	
	/**
	 * Mp4 muxing is enabled or not for the stream
	 * 1 means enabled, -1 means disabled, 0 means no settings for the stream
	 */
	@ApiModelProperty(value = "MP4 muxing whether enabled or not for the stream, 1 means enabled, -1 means disabled, 0 means no settings for the stream")
	private int mp4Enabled = 0;
	
	/**
	 * WebM muxing is enabled or not for the stream
	 * 1 means enabled, -1 means disabled, 0 means no settings for the stream
	 */
	@ApiModelProperty(value = "WebM muxing whether enabled or not for the stream, 1 means enabled, -1 means disabled, 0 means no settings for the stream")
	private int webMEnabled = 0;
	

	public Broadcast() {
		this.type = "liveStream";
	}

	/**
	 * This is the expire time in milliseconds For instance if this value is
	 * 10000 then broadcast should be started in 10 seconds after it is created.
	 * 
	 * If expire duration is 0, then stream will never expire
	 */
	
	
	@ApiModelProperty(value = "the expire time in milliseconds For instance if this value is 10000 then broadcast should be started in 10 seconds after it is created.If expire duration is 0, then stream will never expire")
	private int expireDurationMS;

	/**
	 * RTMP URL where to publish live stream to
	 */
	@ApiModelProperty(value = "the RTMP URL where to publish live stream to")
	private String rtmpURL;

	/**
	 * zombi It is true, if a broadcast that is not added to data store through
	 * rest service or management console It is false by default
	 * 
	 */
	@ApiModelProperty(value = "is true, if a broadcast that is not added to data store through rest service or management console It is false by default")
	private boolean zombi = false;
	
	/**

	 * Number of audio and video packets that is being pending to be encoded 
	 * in the queue
	 */
	
	@ApiModelProperty(value = "the number of audio and video packets that is being pending to be encoded in the queue ")
	private int pendingPacketSize = 0;

	/**
	 * number of hls viewers of the stream
	 */
	
	@ApiModelProperty(value = "the number of HLS viewers of the stream")
	private int hlsViewerCount = 0;

	@ApiModelProperty(value = "the number of WebRTC viewers of the stream")
	private int webRTCViewerCount = 0;
	
	@ApiModelProperty(value = "the number of RTMP viewers of the stream")
	private int rtmpViewerCount = 0;
	
	@ApiModelProperty(value = "the publishing start time of the stream")
	private long startTime = 0;
	
	@ApiModelProperty(value = "the received bytes until now")
	private long receivedBytes = 0;
	
	@ApiModelProperty(value = "the received bytes / duration")
	private long bitrate = 0;
	
	@ApiModelProperty(value = "User - Agent")
	private String userAgent = "N/A";
	
	@ApiModelProperty(value = "latitude of the broadcasting location")
	private String latitude;
	
	@ApiModelProperty(value = "longitude of the broadcasting location")
	private String longitude;
	
	@ApiModelProperty(value = "altitude of the broadcasting location")
	private String altitude;
	
	@ApiModelProperty(value = "If this broadcast is a track of a WebRTC stream. This variable is Id of that stream.")
	private String mainTrackStreamId;
	
	@ApiModelProperty(value = "If this broadcast is main track. This variable hold sub track ids.")
	private List<String> subTrackStreamIds;

	public Broadcast(String status, String name) {
		this.setStatus(status);
		this.setName(name);
		this.type = "liveStream";
	}

	public Broadcast(String name) {

		this.name = name;
		this.type = "liveStream";
	}

	public Broadcast(String name, String ipAddr, String username, String password, String rtspUrl, String type) {

		this.name = name;
		this.ipAddr = ipAddr;
		this.username = username;
		this.password = password;
		this.streamUrl = rtspUrl;
		this.type = type;
	}

	public String getStreamId() {

		if (streamId != null) {
			return streamId;
		}
		if (dbId == null) {
			return null;
		}
		return dbId.toString();

	}

	public void setStreamId(String id) throws Exception {
		if (id == null) {
			throw new Exception("stream id cannot be null");
		}
		this.streamId = id;
	}
	

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Long plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}
	
	public Long getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(Long plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public List<Endpoint> getEndPointList() {
		return endPointList;
	}

	public void setEndPointList(List<Endpoint> endPointList) {
		this.endPointList = endPointList;
	}

	public boolean isIs360() {
		return is360;
	}

	public void setIs360(boolean is360) {
		this.is360 = is360;
	}

	public boolean isPublicStream() {
		return publicStream;
	}

	public void setPublicStream(boolean publicStream) {
		this.publicStream = publicStream;
	}

	public String getListenerHookURL() {
		return listenerHookURL;
	}

	public void setListenerHookURL(String listenerHookURL) {
		this.listenerHookURL = listenerHookURL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getExpireDurationMS() {
		return expireDurationMS;
	}

	public void setExpireDurationMS(int expireDurationMS) {
		this.expireDurationMS = expireDurationMS;
	}

	public String getRtmpURL() {
		return rtmpURL;
	}

	public void setRtmpURL(String rtmpURL) {
		this.rtmpURL = rtmpURL;
	}

	public ObjectId getDbId() {
		return dbId;
	}

	public void setDbId(ObjectId dbId) {
		this.dbId = dbId;
	}

	public boolean isZombi() {
		return zombi;
	}

	public void setZombi(boolean zombi) {
		this.zombi = zombi;
	}

	public void resetStreamId() {
		this.streamId = null;
	}
	
	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}
	public int getHlsViewerCount() {
		return hlsViewerCount;
	}

	public void setHlsViewerCount(int hlsViewerCount) {
		this.hlsViewerCount = hlsViewerCount;
	}

	public int getWebRTCViewerCount() {
		return webRTCViewerCount;
	}

	public void setWebRTCViewerCount(int webRTCViewerCount) {
		this.webRTCViewerCount = webRTCViewerCount;
	}

	public int getRtmpViewerCount() {
		return rtmpViewerCount;
	}

	public void setRtmpViewerCount(int rtmpViewerCount) {
		this.rtmpViewerCount = rtmpViewerCount;
	}

	public int getPendingPacketSize() {
		return pendingPacketSize;
	}

	public void setPendingPacketSize(int pendingPacketSize) {
		this.pendingPacketSize = pendingPacketSize;
	}


	public String getOriginAdress() {
		return originAdress;
	}

	public void setOriginAdress(String originAdress) {
		this.originAdress = originAdress;
	}	
	public int getMp4Enabled() {
		return mp4Enabled;
	}

	public void setMp4Enabled(int mp4Enabled) {
		this.mp4Enabled = mp4Enabled;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getReceivedBytes() {
		return receivedBytes;
	}

	public void setReceivedBytes(long receivedBytes) {
		this.receivedBytes = receivedBytes;
	}

	public long getBitrate() {
		return bitrate;
	}

	public void setBitrate(long bitrate) {
		this.bitrate = bitrate;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getMainTrackStreamId() {
		return mainTrackStreamId;
	}

	public void setMainTrackStreamId(String mainTrackStreamId) {
		this.mainTrackStreamId = mainTrackStreamId;
	}
	
	public List<String> getSubTrackStreamIds() {
		return subTrackStreamIds;
	}

	public void setSubTrackStreamIds(List<String> subTrackStreamIds) {
		this.subTrackStreamIds = subTrackStreamIds;
	}

	public int getWebMEnabled() {
		return webMEnabled;
	}

	public void setWebMEnabled(int webMEnabled) {
		this.webMEnabled = webMEnabled;
	}
}
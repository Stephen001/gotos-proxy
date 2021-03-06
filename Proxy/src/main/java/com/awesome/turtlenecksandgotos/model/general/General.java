package com.awesome.turtlenecksandgotos.model.general;

import java.net.URI;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.awesome.turtlenecksandgotos.model.author.HasAuthor;
import com.awesome.turtlenecksandgotos.model.banner.HasBanner;
import com.awesome.turtlenecksandgotos.model.date.HasDate;
import com.awesome.turtlenecksandgotos.model.downloads.HasDownloads;
import com.awesome.turtlenecksandgotos.model.downloadsize.HasDownloadSize;
import com.awesome.turtlenecksandgotos.model.fans.HasFans;
import com.awesome.turtlenecksandgotos.model.freedownload.IsFreeDownload;
import com.awesome.turtlenecksandgotos.model.hubtype.HasHubType;
import com.awesome.turtlenecksandgotos.model.hubtype.HubType;
import com.awesome.turtlenecksandgotos.model.icon.HasIcon;
import com.awesome.turtlenecksandgotos.model.lastplayed.HasLastPlayed;
import com.awesome.turtlenecksandgotos.model.lastupdated.HasLastUpdated;
import com.awesome.turtlenecksandgotos.model.listing.HasListingType;
import com.awesome.turtlenecksandgotos.model.listing.ListingType;
import com.awesome.turtlenecksandgotos.model.longdesc.HasLongDesc;
import com.awesome.turtlenecksandgotos.model.multiplayer.IsMultiplayer;
import com.awesome.turtlenecksandgotos.model.screenshots.HasScreenshots;
import com.awesome.turtlenecksandgotos.model.shortdesc.HasShortDesc;
import com.awesome.turtlenecksandgotos.model.smallicon.HasSmallIcon;
import com.awesome.turtlenecksandgotos.model.tags.HasTags;
import com.awesome.turtlenecksandgotos.model.tags.Tags;
import com.awesome.turtlenecksandgotos.model.title.HasTitle;
import com.awesome.turtlenecksandgotos.model.version.HasVersion;
import com.awesome.turtlenecksandgotos.model.video.HasVideo;

@XmlType
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class General implements HasHubType, HasTitle, HasShortDesc, HasLongDesc, HasAuthor, HasDate, HasLastUpdated, HasDownloadSize, HasDownloads, HasFans, HasScreenshots, HasListingType, IsFreeDownload, HasVersion, HasTags, HasLastPlayed, IsMultiplayer, HasBanner, HasIcon, HasSmallIcon, HasVideo {
	private String title;
	private HubType hubType;
	private String shortDescription;
	private String longDescription;
	private String author;
	private Date date;
	private Date lastUpdated;
	private int	downloadSize;
	private int downloads;
	private int	fans;
	private int screenshots;
	private ListingType listing;
	private boolean freeDownload;
	private String version;
	private Tags tags;
	private Date lastPlayed;
	private boolean multiplayer;
	private URI banner;
	private URI icon;
	private URI smallIcon;
	private URI video;
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public HubType getHubType() {
		return hubType;
	}

	@Override
	public void setHubType(HubType type) {
		this.hubType = type;
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public void setShortDescription(String shortdesc) {
		this.shortDescription = shortdesc;
	}

	@Override
	public String getLongDescription() {
		return longDescription;
	}

	@Override
	public void setLongDescription(String shortdesc) {
		this.longDescription = shortdesc;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String shortdesc) {
		this.author = shortdesc;
	}

	@Override
	public Date getLastUpdated() {
		return lastUpdated;
	}

	@Override
	public void setLastUpdated(Date date) {
		this.lastUpdated = date;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int getDownloadSize() {
		return downloadSize;
	}

	@Override
	public void setDownloadSize(int date) {
		this.downloadSize = date;
	}

	@Override
	public int getDownloads() {
		return downloads;
	}

	@Override
	public void setDownloads(int date) {
		this.downloads = date;
	}

	@Override
	public int getFans() {
		return fans;
	}

	@Override
	public void setFans(int date) {
		this.fans = date;
	}

	@Override
	public int getScreenshots() {
		return screenshots;
	}

	@Override
	public void setScreenshots(int title) {
		this.screenshots = title;
	}

	@Override
	public ListingType getListing() {
		return listing;
	}

	@Override
	public void setListing(ListingType type) {
		this.listing = type;
	}

	@Override
	public boolean isFreeDownload() {
		return freeDownload;
	}

	@Override
	public void setFreeDownload(boolean free) {
		this.freeDownload = free;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public Tags getTags() {
		return tags;
	}

	@Override
	public void setTags(Tags tags) {
		this.tags = tags;
	}

	@Override
	public Date getLastPlayed() {
		return lastPlayed;
	}

	@Override
	public void setLastPlayed(Date date) {
		this.lastPlayed = date;
	}

	@Override
	public boolean isMultiplayer() {
		return multiplayer;
	}

	@Override
	public void setMultiplayer(boolean multiplayer) {
		this.multiplayer = multiplayer;
	}

	@Override
	public URI getBanner() {
		return banner;
	}

	@Override
	public void setBanner(URI banner) {
		this.banner = banner;
	}

	@Override
	public URI getIcon() {
		return icon;
	}

	@Override
	public void setIcon(URI icon) {
		this.icon = icon;
	}
	
	@Override
	public URI getSmallIcon() {
		return smallIcon;
	}

	@Override
	public void setSmallIcon(URI icon) {
		this.smallIcon = icon;
	}

	@Override
	public URI getVideo() {
		return video;
	}

	@Override
	public void setVideo(URI video) {
		this.video = video;
	}
}

package arc.com.arctrails;

import android.graphics.Bitmap;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import androidx.work.Data;

/**
 * Created by graememorgan on 2018-02-26.
 *
 * Simplified verion of GPX data that can be stored in the firebase database
 */

public class Trail {
    private Metadata metadata;
    private List<Waypoint> waypoints;
    private List<Track> tracks;

    public static class Metadata{
        private String name;
        private String description;
        private String location;
        private int difficulty;
        private String notes;
        private String trailID;
        private List<String> imageIDs;
        private double rating;
        private int numRatings;
        private int numFlags;
        private double headLat, headLong;
        private int lengthCategory;
        private boolean allowEdit;

        public int getLengthCategory() {
            return lengthCategory;
        }

        public void setLengthCategory(int lengthCategory) {
            this.lengthCategory = lengthCategory;
        }

        public double getHeadLat() {
            return headLat;
        }

        public void setHeadLat(double headLat) {
            this.headLat = headLat;
        }

        public double getHeadLong() {
            return headLong;
        }

        public void setHeadLong(double headLong) {
            this.headLong = headLong;
        }

        public Metadata()
        {
            imageIDs = new ArrayList<>();
        }

        public String getTrailID() {
            return trailID;
        }

        public void setTrailID(String id) {
            this.trailID = id;
        }

        public List<String> getImageIDs() {
            return imageIDs;
        }

        public void setImageIDs(List<String> ids) {
            this.imageIDs = ids;
        }

        public void addImageID(String id)
        {
            imageIDs.add(id);
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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(int difficulty) {
            this.difficulty = difficulty;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getNumRatings() {
            return numRatings;
        }

        public void setNumRatings(int numRatings) {
            this.numRatings = numRatings;
        }

        public int getNumFlags() {
            return numFlags;
        }

        public void setNumFlags(int numFlags) {
            this.numFlags = numFlags;
        }

        public boolean isAllowEdit() {
            return allowEdit;
        }

        public void setAllowEdit(boolean allowEdit) {
            this.allowEdit = allowEdit;
        }
    }

    public static class Waypoint {
        private String waypointName;
        private String type;
        private String comment;

        //it was planned for waypoints to allow single images, but this is being
        //avoided due to time constraints, memory concerns, and difficulty implementing
        //custom infowindows that allow images

//        private String imageID;

        private double latitude;
        private double longitude;

        public Waypoint(){}

        public Waypoint(String name, double lat, double lng) {
            waypointName = name;
            latitude = lat;
            longitude = lng;
        }

//        public String getImageID() {
//            return imageID;
//        }
//
//        public void setImageID(String imageID) {
//            this.imageID = imageID;
//        }

        public String getWaypointName() {
            return waypointName;
        }

        public void setWaypointName(String name) {
            this.waypointName = name;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getWaypointType() {
            return type;
        }

        public void setWaypointType(String type) {
            this.type = type;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

    public static class Track {
        private List<Waypoint> trackPoints;

        public Track(){
            this( new ArrayList<Waypoint>() );
        }

        public Track(List<Waypoint> list){
            trackPoints = list;
        }

        public List<Waypoint> getTrackPoints() {
            return trackPoints;
        }

        public void setTrackPoints(List<Waypoint> trackPoints) {
            this.trackPoints = trackPoints;
        }
    }

    public Trail() {
        this(null,null,null);
    }

    public Trail(String name, String description, String location) {
        this.metadata = new Metadata();
        metadata.setName(name);
        metadata.setDescription(description);
        metadata.setLocation(location);
        this.waypoints = new ArrayList<>();
        this.tracks = new ArrayList<>();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    public void addWaypoint(Waypoint waypoint){
        waypoints.add(waypoint);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public void printTrail() {
        System.out.printf("Metadata:\n" +
                "Name: %s\n" +
                "Description: %s\n" +
                "Location: %s\n" +
                "Difficulty: %d\n" +
                "Notes: %s\n" +
                "TrailID: %s\n" +
                "Rating: %f\n\n" +
                "Waypoints:%s\n" +
                /*"Type: %s\n" +
                "Comment: %s\n" +
                "ImageID: %s\n" +
                "Latitude: %3f\n" +
                "Longtitude: %3f\n\n" +*/
                "Tracks:%s\n" +
                "Trackpoints: ",
                metadata.name, metadata.description, metadata.location,
                metadata.difficulty, metadata.notes, metadata.trailID, metadata.rating,
                getWaypoints(), getTracks()
        );
    }
}

package pink.zak.client.wavybot.models.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.FailureResponse;
import pink.zak.client.wavybot.models.Task;
import pink.zak.client.wavybot.models.Tuple;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.impl.AlbumImpl;
import pink.zak.client.wavybot.models.impl.ArtistImpl;
import pink.zak.client.wavybot.models.impl.FailureResponseImpl;
import pink.zak.client.wavybot.models.impl.TaskImpl;
import pink.zak.client.wavybot.models.impl.TrackImpl;
import pink.zak.client.wavybot.models.impl.UserImpl;
import pink.zak.client.wavybot.models.impl.WavyUserImpl;
import pink.zak.client.wavybot.models.spotify.Album;
import pink.zak.client.wavybot.models.spotify.Artist;
import pink.zak.client.wavybot.models.spotify.Track;

import java.util.HashMap;
import java.util.Map;

public class ModelBuilder {
    @NotNull
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @NotNull
    private final RiptideImpl riptide;

    public static final TypeReference<FailureResponseImpl> FAILURE_RESPONSE_REFERENCE = new TypeReference<>() {};

    public static final TypeReference<HashMap<Long, Tuple<String, Integer>>> LEADERBOARD_REFERENCE = new TypeReference<>(){};

    private static final TypeReference<UserImpl> USER_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<WavyUserImpl> WAVY_USER_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<TaskImpl> TASK_REFERENCE = new TypeReference<>(){};

    private static final TypeReference<AlbumImpl> ALBUM_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<ArtistImpl> ARTIST_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<TrackImpl> TRACK_REFERENCE = new TypeReference<>(){};

    private static final TypeReference<HashMap<String, AlbumImpl>> BULK_REQUEST_ALBUM_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<HashMap<String, ArtistImpl>> BULK_REQUEST_ARTIST_REFERENCE = new TypeReference<>(){};
    private static final TypeReference<HashMap<String, TrackImpl>> BULK_REQUEST_TRACK_REFERENCE = new TypeReference<>(){};

    public ModelBuilder(@NotNull RiptideImpl riptide) {
        this.riptide = riptide;
    }

    public static FailureResponse createFailureResponse(String body) {
        try {
            return OBJECT_MAPPER.readValue(body, FAILURE_RESPONSE_REFERENCE);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Long, Tuple<String, Integer>> createLeaderboard(String body) {
        try {
            return OBJECT_MAPPER.readValue(body, LEADERBOARD_REFERENCE);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser(String body) {
        try {
            UserImpl user = OBJECT_MAPPER.readValue(body, USER_REFERENCE);
            user.setRiptide(this.riptide);
            return user;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WavyUser createWavyUser(String body) {
        try {
            WavyUserImpl wavyUser = OBJECT_MAPPER.readValue(body, WAVY_USER_REFERENCE);
            wavyUser.setRiptide(this.riptide);
            return wavyUser;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Task createTask(String body) {
        try {
            TaskImpl task = OBJECT_MAPPER.readValue(body, TASK_REFERENCE);
            task.setRiptide(this.riptide);
            return task;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Album createAlbum(String body) {
        try {
            AlbumImpl album = OBJECT_MAPPER.readValue(body, ALBUM_REFERENCE);
            album.setRiptide(this.riptide);
            return album;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Artist createArtist(String body) {
        try {
            ArtistImpl artist = OBJECT_MAPPER.readValue(body, ARTIST_REFERENCE);
            artist.setRiptide(this.riptide);
            return artist;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Track createTrack(String body) {
        try {
            TrackImpl track = OBJECT_MAPPER.readValue(body, TRACK_REFERENCE);
            track.setRiptide(this.riptide);
            return track;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, ? extends Album> createAlbums(String body) {
        try {
            Map<String, AlbumImpl> albumMap = OBJECT_MAPPER.readValue(body, BULK_REQUEST_ALBUM_REFERENCE);
            albumMap.values().forEach(album -> album.setRiptide(this.riptide));
            return albumMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Map<String, ? extends Artist> createArtists(String body) {
        try {
            Map<String, ArtistImpl> artistMap = OBJECT_MAPPER.readValue(body, BULK_REQUEST_ARTIST_REFERENCE);
            artistMap.values().forEach(artist -> artist.setRiptide(this.riptide));
            return artistMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, ? extends Track> createTracks(String body) {
        try {
            Map<String, TrackImpl> trackMap = OBJECT_MAPPER.readValue(body, BULK_REQUEST_TRACK_REFERENCE);
            trackMap.values().forEach(track -> track.setRiptide(this.riptide));
            return trackMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

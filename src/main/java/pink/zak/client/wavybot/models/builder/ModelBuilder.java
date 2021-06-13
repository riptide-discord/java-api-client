package pink.zak.client.wavybot.models.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import pink.zak.client.wavybot.Riptide;
import pink.zak.client.wavybot.RiptideImpl;
import pink.zak.client.wavybot.models.Album;
import pink.zak.client.wavybot.models.Artist;
import pink.zak.client.wavybot.models.Task;
import pink.zak.client.wavybot.models.Track;
import pink.zak.client.wavybot.models.User;
import pink.zak.client.wavybot.models.WavyUser;
import pink.zak.client.wavybot.models.impl.AlbumImpl;
import pink.zak.client.wavybot.models.impl.ArtistImpl;
import pink.zak.client.wavybot.models.impl.TaskImpl;
import pink.zak.client.wavybot.models.impl.TrackImpl;
import pink.zak.client.wavybot.models.impl.UserImpl;
import pink.zak.client.wavybot.models.impl.WavyUserImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModelBuilder {
    @NotNull
    private final ObjectMapper objectMapper = new ObjectMapper();
    @NotNull
    private final RiptideImpl riptide;

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

    public User createUser(String body) {
        try {
            UserImpl user = this.objectMapper.readValue(body, USER_REFERENCE);
            user.setRiptide(this.riptide);
            return this.objectMapper.readValue(body, USER_REFERENCE);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WavyUser createWavyUser(String body) {
        try {
            WavyUserImpl wavyUser = this.objectMapper.readValue(body, WAVY_USER_REFERENCE);
            wavyUser.setRiptide(this.riptide);
            return wavyUser;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Task createTask(String body) {
        try {
            TaskImpl task = this.objectMapper.readValue(body, TASK_REFERENCE);
            task.setRiptide(this.riptide);
            return task;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Album createAlbum(String body) {
        try {
            AlbumImpl album = this.objectMapper.readValue(body, ALBUM_REFERENCE);
            album.setRiptide(this.riptide);
            return album;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Artist createArtist(String body) {
        try {
            ArtistImpl artist = this.objectMapper.readValue(body, ARTIST_REFERENCE);
            artist.setRiptide(this.riptide);
            return artist;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Track createTrack(String body) {
        try {
            TrackImpl track = this.objectMapper.readValue(body, TRACK_REFERENCE);
            track.setRiptide(this.riptide);
            return track;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, ? extends Album> createAlbums(String body) {
        try {
            Map<String, AlbumImpl> albumMap = this.objectMapper.readValue(body, BULK_REQUEST_ALBUM_REFERENCE);
            albumMap.values().forEach(album -> album.setRiptide(this.riptide));
            return albumMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Map<String, ? extends Artist> createArtists(String body) {
        try {
            Map<String, ArtistImpl> artistMap = this.objectMapper.readValue(body, BULK_REQUEST_ARTIST_REFERENCE);
            artistMap.values().forEach(artist -> artist.setRiptide(this.riptide));
            return artistMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, ? extends Track> createTracks(String body) {
        try {
            Map<String, TrackImpl> trackMap = this.objectMapper.readValue(body, BULK_REQUEST_TRACK_REFERENCE);
            trackMap.values().forEach(track -> track.setRiptide(this.riptide));
            return trackMap;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

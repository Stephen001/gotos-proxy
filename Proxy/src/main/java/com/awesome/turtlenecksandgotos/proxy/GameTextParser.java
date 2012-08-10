package com.awesome.turtlenecksandgotos.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import com.awesome.turtlenecksandgotos.logic.PushbackBufferedReader;
import com.awesome.turtlenecksandgotos.logic.TextParser;
import com.awesome.turtlenecksandgotos.logic.TextSectionParser;
import com.awesome.turtlenecksandgotos.model.GameHub;
import com.awesome.turtlenecksandgotos.model.author.AuthorHandler;
import com.awesome.turtlenecksandgotos.model.banner.BannerHandler;
import com.awesome.turtlenecksandgotos.model.date.DateHandler;
import com.awesome.turtlenecksandgotos.model.downloads.DownloadsHandler;
import com.awesome.turtlenecksandgotos.model.downloadsize.DownloadSizeHandler;
import com.awesome.turtlenecksandgotos.model.fans.FansHandler;
import com.awesome.turtlenecksandgotos.model.general.General;
import com.awesome.turtlenecksandgotos.model.general.GeneralHandler;
import com.awesome.turtlenecksandgotos.model.host.HostHandler;
import com.awesome.turtlenecksandgotos.model.hubtype.HubTypeHandler;
import com.awesome.turtlenecksandgotos.model.icon.IconHandler;
import com.awesome.turtlenecksandgotos.model.lastplayed.LastPlayedHandler;
import com.awesome.turtlenecksandgotos.model.lastupdated.LastUpdatedHandler;
import com.awesome.turtlenecksandgotos.model.listing.ListingHandler;
import com.awesome.turtlenecksandgotos.model.longdesc.LongDescHandler;
import com.awesome.turtlenecksandgotos.model.multiplayer.IsMultiplayerHandler;
import com.awesome.turtlenecksandgotos.model.players.PlayersHandler;
import com.awesome.turtlenecksandgotos.model.screenshots.ScreenshotsHandler;
import com.awesome.turtlenecksandgotos.model.serverversion.ServerVersionHandler;
import com.awesome.turtlenecksandgotos.model.shortdesc.ShortDescHandler;
import com.awesome.turtlenecksandgotos.model.smallicon.SmallIconHandler;
import com.awesome.turtlenecksandgotos.model.status.StatusHandler;
import com.awesome.turtlenecksandgotos.model.tags.TagsHandler;
import com.awesome.turtlenecksandgotos.model.title.TitleHandler;
import com.awesome.turtlenecksandgotos.model.url.URIHandler;
import com.awesome.turtlenecksandgotos.model.version.VersionHandler;
import com.awesome.turtlenecksandgotos.model.video.VideoHandler;
import com.awesome.turtlenecksandgotos.model.world.World;
import com.awesome.turtlenecksandgotos.model.world.WorldHandler;

/**
 * Session Bean implementation class DeveloperTextParser
 */
@Stateless
public class GameTextParser implements GameTextParserLocal {
	
	private final TextParser<GameHub> parser = new TextParser<GameHub>();
	
    /**
     * Default constructor. 
     */
    public GameTextParser() {
    	TextSectionParser<General> generalParser = new TextSectionParser<General>();
        generalParser.registerHandler("type", new HubTypeHandler<General>());
        generalParser.registerHandler("title", new TitleHandler<General>());
        generalParser.registerHandler("short_desc", new ShortDescHandler<General>());
        generalParser.registerHandler("long_desc", new LongDescHandler<General>());
        generalParser.registerHandler("author", new AuthorHandler<General>());
        generalParser.registerHandler("date", new DateHandler<General>());
        generalParser.registerHandler("last_updated", new LastUpdatedHandler<General>());
        generalParser.registerHandler("last_played", new LastPlayedHandler<General>());
        generalParser.registerHandler("download_size", new DownloadSizeHandler<General>());
        generalParser.registerHandler("downloads", new DownloadsHandler<General>());
        generalParser.registerHandler("fans", new FansHandler<General>());
        generalParser.registerHandler("screenshots", new ScreenshotsHandler<General>());
        generalParser.registerHandler("listing", new ListingHandler<General>());
        generalParser.registerHandler("version", new VersionHandler<General>());
        generalParser.registerHandler("tags", new TagsHandler<General>());
        generalParser.registerHandler("multi_player", new IsMultiplayerHandler<General>());
        generalParser.registerHandler("banner", new BannerHandler<General>());
        generalParser.registerHandler("icon", new IconHandler<General>());
        generalParser.registerHandler("small_icon", new SmallIconHandler<General>());
        generalParser.registerHandler("video", new VideoHandler<General>());
        parser.registerHandler(Pattern.compile("^general$"), General.class, generalParser, new GeneralHandler<GameHub>());
        TextSectionParser<World> worldParser = new TextSectionParser<World>();
        worldParser.registerHandler("url", new URIHandler<World>());
        worldParser.registerHandler("status", new StatusHandler<World>());
        worldParser.registerHandler("players", new PlayersHandler<World>());
        worldParser.registerHandler("host", new HostHandler<World>());
        worldParser.registerHandler("server_version", new ServerVersionHandler<World>());
        parser.registerHandler(Pattern.compile("^world/([0-9]+)$"), World.class, worldParser, new WorldHandler<GameHub>());
    }

    public GameHub parse(final InputStream stream) throws IOException {
    	GameHub hub = new GameHub();
    	hub = parser.parse(new PushbackBufferedReader(new InputStreamReader(stream)), hub);
    	return hub;
    }
}

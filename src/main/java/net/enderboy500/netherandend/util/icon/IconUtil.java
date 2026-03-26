package net.enderboy500.netherandend.util.icon;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.icu.impl.ClassLoaderUtil;
import net.enderboy500.netherandend.NetherAndEnd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IconUtil {
    private static final String LINK = "https://raw.githubusercontent.com/EnderBoy500/Data/refs/heads/main/data/netherandend-icons.json";
    public static boolean checkAvailability(Icon icon) {
        try {
            URI uri = new URI(LINK);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonObject iconsO = json.getAsJsonObject("icons");
            boolean b = iconsO.get(icon.getId()).getAsJsonObject().get("available").getAsBoolean();
            return b;
        } catch (Exception e) {
            NetherAndEnd.LOGGER.error("Failed to fetch from URL: " + LINK, e);
        }
        return false;
    }
    public static boolean checkCorrectTime(Icon icon) {
        try {
            URI uri = new URI(LINK);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonObject icons = json.getAsJsonObject("icons").get(icon.getId()).getAsJsonObject();
            int startDay = icons.get("start").getAsJsonObject().get("day").getAsInt();
            int startMonth = icons.get("start").getAsJsonObject().get("month").getAsInt();
            int endDay = icons.get("end").getAsJsonObject().get("day").getAsInt();
            int endMonth = icons.get("end").getAsJsonObject().get("month").getAsInt();
            Calendar calendar = Calendar.getInstance();
            return (calendar.get(Calendar.MONTH) >= startMonth && calendar.get(Calendar.DATE) >= startDay) && (calendar.get(Calendar.MONTH) <= endMonth && calendar.get(Calendar.DATE) <= endDay);
        } catch (Exception e) {
            
        }
        return false;
    }

    public static boolean checkEverything(Icon icon) {
        try {
            URI uri = new URI(LINK);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            JsonObject icons = json.getAsJsonObject("icons").get(icon.getId()).getAsJsonObject();
            int startDay = icons.get("start").getAsJsonObject().get("day").getAsInt();
            int startMonth = icons.get("start").getAsJsonObject().get("month").getAsInt();
            int endDay = icons.get("end").getAsJsonObject().get("day").getAsInt();
            int endMonth = icons.get("end").getAsJsonObject().get("month").getAsInt();
            Calendar calendar = Calendar.getInstance();
            boolean b = icons.get("available").getAsBoolean();
            return (calendar.get(Calendar.MONTH) >= startMonth && calendar.get(Calendar.DATE) >= startDay) && (calendar.get(Calendar.MONTH) <= endMonth && calendar.get(Calendar.DATE) <= endDay) && b;
        } catch (Exception e) {
            NetherAndEnd.LOGGER.info("Failed to display icon");
        }
        return false;
    }
}

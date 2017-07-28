package study.animationapplication;

import android.util.Log;
import android.widget.ImageView;

/**
 * Created by sungju on 2017-07-28.
 */

public class GameController {
    public boolean collisionCheck(ImageView player, ImageView target) {
        float playerWidth = player.getX() + player.getWidth();
        float playerHeight = player.getY() + player.getHeight();
        float targetWidth = target.getX() + target.getWidth();
        float targetHeight = target.getY() + target.getHeight();
        if(player.getX() <= targetWidth && playerWidth >= target.getX()) {
            if (player.getY() <= targetHeight && playerHeight >= target.getY()) {
                return true;
            }
        }
        return false;
    }

}

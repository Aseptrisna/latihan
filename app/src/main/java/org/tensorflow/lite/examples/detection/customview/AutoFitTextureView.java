/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.detection.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;

import org.tensorflow.lite.examples.detection.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import static android.content.ContentValues.TAG;

/** A {@link TextureView} that can be adjusted to a specified aspect ratio. */
public class AutoFitTextureView extends TextureView {
  private int ratioWidth = 0;
  private int ratioHeight =0;


  public AutoFitTextureView(final Context context) {
    this(context, null);
  }

  public AutoFitTextureView(final Context context, final AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public AutoFitTextureView(final Context context, final AttributeSet attrs, final int defStyle) {
    super(context, attrs, defStyle);
  }

  /**
   * Sets the aspect ratio for this view. The size of the view will be measured based on the ratio
   * calculated from the parameters. Note that the actual sizes of parameters don't matter, that is,
   * calling setAspectRatio(2, 3) and setAspectRatio(4, 6) make the same result.
   *
   * @param width Relative horizontal size
   * @param height Relative vertical size
   */
  public void setAspectRatio(final int width, final int height) {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Size cannot be negative.");
    }
    ratioWidth = width;
    ratioHeight = height;
    requestLayout();
  }

  @Override
  protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    final int width = MeasureSpec.getSize(widthMeasureSpec);
    final int height = MeasureSpec.getSize(heightMeasureSpec);
//    getBitmap(tv);
    if (0 == ratioWidth || 0 == ratioHeight) {
      setMeasuredDimension(width, height);
    } else {
      if (width < height * ratioWidth / ratioHeight) {
        setMeasuredDimension(width, width * ratioHeight / ratioWidth);
      } else {
        setMeasuredDimension(height * ratioWidth / ratioHeight, height);
      }
    }
  }
  public void getBitmap(TextureView vv) {
    Date now = new Date();
    android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
    String mPath = Environment.getExternalStorageDirectory().toString()
            + "/Pictures/" + now + ".png";
    Toast.makeText(getContext(), "Capturing Screenshot: " + mPath, Toast.LENGTH_SHORT).show();

    Bitmap bm = vv.getBitmap();
    if(bm == null)
      Log.e(TAG,"bitmap is null");

    OutputStream fout = null;
    File imageFile = new File(mPath);

    try {
      fout = new FileOutputStream(imageFile);
      bm.compress(Bitmap.CompressFormat.PNG, 90, fout);
      fout.flush();
      fout.close();
    } catch (FileNotFoundException e) {
      Log.e(TAG, "FileNotFoundException");
      e.printStackTrace();
    } catch (IOException e) {
      Log.e(TAG, "IOException");
      e.printStackTrace();
    }
  }

//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    // Inflate the menu; this adds items to the action bar if it is present.
//    getMenuInflater().inflate(R.menu.media_player_video, menu);
//    return true;
//  }


}

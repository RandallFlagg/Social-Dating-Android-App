/**
 *  Copyright 2015-2016 by Pierre-Henry SORIA <soria.pierrehenry@gmail.com>, All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package uk.hizup.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Pierre-Henry on 17/01/2016.
 */
public class MyBrowser extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        // Get the URL from the WebResourceRequest
        String url = request.getUrl().toString();

        // Check if the URL's host ends with the allowed site URL
        // Assuming MainActivity.URL_SITE is a constant defining your allowed domain
        if (Uri.parse(url).getHost() != null && Uri.parse(url).getHost().endsWith(MainActivity.URL_SITE)) {
            // If it's your site, let the WebView load it
            return false;
        }

        // If it's an external URL, open it in the default browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }

}

/*
 * Copyright 2016 Units of Measurement
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package space.uom.quantifier;

import org.agorava.api.oauth.application.OAuthAppSettings;
import org.agorava.api.oauth.application.OAuthAppSettingsBuilder;
import org.agorava.api.oauth.application.OAuthApplication;
import org.agorava.api.oauth.application.Param;
import org.agorava.github.GitHub;

import tec.uom.client.fitbit.Fitbit;
import tec.uom.client.runkeeper.RunKeeper;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Werner Keil
 */
public class SettingsProducer {

    @ApplicationScoped
    @Produces
    @GitHub
    @OAuthApplication(params = {@Param(name = OAuthAppSettingsBuilder.PREFIX, value = "github")})
    public OAuthAppSettings gitHubSettings;
    
    @ApplicationScoped
    @Produces
    @Fitbit
    @OAuthApplication(params = {@Param(name = OAuthAppSettingsBuilder.PREFIX, value = "fitbit")})
    public OAuthAppSettings fitbitSettings;
    
    @ApplicationScoped
    @Produces
    @RunKeeper
    @OAuthApplication(params = {@Param(name = OAuthAppSettingsBuilder.PREFIX, value = "runkeeper")})
    public OAuthAppSettings runkeeperSettings;

//    @ApplicationScoped
//    @Produces
//    @Strava
//    @OAuthApplication(params = {@Param(name = OAuthAppSettingsBuilder.PREFIX, value = "strava")})
//    public OAuthAppSettings stravaSettings;
/*    
    @ApplicationScoped
    @Produces
    @Withings
    @OAuthApplication(params = {@Param(name = OAuthAppSettingsBuilder.PREFIX, value = "withings")})
    public OAuthAppSettings withingsSettings;
    */
}

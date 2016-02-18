/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.emergency;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

/**
 * Custom {@link EditTextPreference} that allows us to refresh and update the summary.
 */
public class EmergencyEditTextPreference extends EditTextPreference
        implements ReloadablePreferenceInterface {

    public EmergencyEditTextPreference(Context context) {
        super(context);
    }

    public EmergencyEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void reloadFromPreference() {
        setText(getPersistedString(""));
    }

    @Override
    public CharSequence getSummary() {
        String text = getText();
        return (text == null || text.isEmpty() ? super.getSummary() : text);
    }
}

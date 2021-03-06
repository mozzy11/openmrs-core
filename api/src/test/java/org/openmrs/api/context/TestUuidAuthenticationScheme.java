/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api.context;

import org.openmrs.User;

/*
 * This test auth scheme logs a user simply based on asserting that its UUID is valid and points to an exisiting user.
 */
public class TestUuidAuthenticationScheme extends DaoAuthenticationScheme {

	@Override
	public Authenticated authenticate(Credentials credentials) throws ContextAuthenticationException {
		
		TestUuidCredentials creds = (TestUuidCredentials) credentials;
		
		User user = getContextDAO().getUserByUuid(creds.getUserUuid()); // that's the actual authentication
		
		return new BasicAuthenticated(user, "test-scheme");
	}
}
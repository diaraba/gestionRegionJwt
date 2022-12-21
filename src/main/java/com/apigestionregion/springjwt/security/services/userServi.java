package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userServi {
List<User> afficherUser();
}

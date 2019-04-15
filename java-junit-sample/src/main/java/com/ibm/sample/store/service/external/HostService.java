package com.ibm.sample.store.service.external;

import com.ibm.sample.store.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HostService {

    @Autowired
    private ExternalSystemProxy externalSystemProxy;

    public int expand(Customer customer) {

        // Host magic happening here to retrieve the value
        customer.setHostValue("host value");
        return 100;
    }


    public void connect() throws IOException {

        if (externalSystemProxy.connectionAvailable("10.20.30.40")) {
            // Do something here
        }
    }

}

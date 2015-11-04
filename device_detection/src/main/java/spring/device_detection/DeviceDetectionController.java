package spring.device_detection;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeviceDetectionController {
    
    @RequestMapping("/detect-device")
    public @ResponseBody String detectDevice(Device device) { //@responseBody tells Spring MVC to write the returned object into the response body, rather than to render a model into a view.
        String deviceType = "unknown";
        if (device.isNormal()) {
            deviceType = "normal";

        } else if (device.isMobile()) {
            deviceType = "mobile";
        } else if (device.isTablet()) {
            deviceType = "tablet";
        }
        return "Hello " + deviceType + " browser";
    }
}

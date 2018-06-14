package lvov;

import org.springframework.context.annotation.Import;
import org.springframework.security.access.SecurityConfig;

@Import({SecurityConfig.class})

public interface Application {}

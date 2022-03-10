package pidev.utils;

import pidev.models.Roles;

/**
 *
 * @author raslen
 */
public final class UserSession {

    private static UserSession instance;

    private Long userId;
    private Roles role;

    private UserSession(Long userId, Roles role) {
        this.userId = userId;
        this.role = role;
    }

    public static UserSession getInstace(Long userId, Roles role) {
        if (instance == null) {
            instance = new UserSession(userId, role);
        }
        return instance;
    }

    public static UserSession getInstace() {
        if (instance != null) {
            return instance;
        }
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    public Roles getRole() {
        return role;
    }

    public void cleanUserSession() {
        userId = null;// or null
        role = null;
    }

    @Override
    public String toString() {
        return "UserSession{"
                + "UserId='" + userId + '\''
                + ", Role=" + role
                + '}';
    }
}

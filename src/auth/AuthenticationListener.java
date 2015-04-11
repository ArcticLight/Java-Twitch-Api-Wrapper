package auth;

/**
 * Interface for listening to twitch.tv authentication
 * access tokens
 */
interface AuthenticationListener {
    /**
     * Called when a twitch.tv authentication access token has been received.
     * @param token twitch.tv authentication access token
     */
    public void onAccessTokenReceived(String token);

    /**
     * An authentication error occurred.
     * Usually due to user denying the request.
     * @param error Error name
     * @param description Error description
     */
    public void onAuthenticationError(String error, String description);
}
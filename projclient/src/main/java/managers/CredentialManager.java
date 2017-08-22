package managers;

import io.github.iwag.finalproj.models.entities.CredientialEntity;
import io.github.iwag.finalproj.models.entities.ProfileEntity;

public class CredentialManager {

    private ProfileEntity pe;

    public CredentialManager() {

    }

    public ProfileEntity getPe() {
        return pe;
    }

    public void setPe(ProfileEntity pe) {
        this.pe = pe;
    }
}

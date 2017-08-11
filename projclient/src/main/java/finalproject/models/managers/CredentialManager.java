package finalproject.models.managers;

import finalproject.models.entities.CredientialEntity;
import finalproject.models.entities.ProfileEntity;

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

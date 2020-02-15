import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private List<Article> listOfFavorites;

    public Favorites(List<Article> listOfFavorites){
        this.listOfFavorites = new ArrayList<>();
    }

    public void removeFromFavorite(){

    }
    public List<Article> getListOfFavorites(){
        return listOfFavorites;
    }
}

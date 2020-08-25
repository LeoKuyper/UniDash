package subject

import javafx.beans.property.*
import javafx.collections.ObservableList

class Subject (val id: Int, var name: String, var code: String,  var credits: Int, var hours: Int, var price: Float){
    val idProperty = SimpleIntegerProperty(this, "id", id)
    var nameProperty = SimpleStringProperty(this, "name", name)
    var codeProperty = SimpleStringProperty(this, "code", code)
    var creditsProperty = SimpleIntegerProperty(this, "credits", credits)
    var hoursProperty = SimpleIntegerProperty(this, "hours", hours)
    var priceProperty = SimpleFloatProperty(this, "price", price)
}
package View

import tornadofx.*

class MainView : View("UniDash") {

    override val root = borderpane {

//        top(NeighborhoodView::class)
        left(UniView::class)
//        addClass(Styles.main)
    }

}
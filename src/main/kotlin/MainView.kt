import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*
import views.HomeView
import views.SideView

class MainView: View("UniDash") {
    override val root = vbox {



        borderpane {

            center = vbox{
                setPrefSize(100.0, 960.0)
                style{
                    backgroundColor += Color.rgb(20, 31, 38)
                }
                vbox {
                    button("Create University") {
                        action { println("Create University Button pressed!")
                            workspace.dock<HomeView>()}
                    }
                    setPrefSize(100.0, 960.0)
                    useMaxWidth = true
                    useMaxHeight = true
                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

            }

        }



    }

}
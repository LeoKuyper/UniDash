package views

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

class PoolView: View() {

    override val root = vbox {

        borderpane {


            left = vbox() {
                setPrefSize(200.0, 960.0)
                useMaxHeight = true

                label ("UniDash"){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                button("University") {

                    action { println("University Button pressed!")
                        workspace.dock<HomeView>()}


                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                }
                button("Subjects") {

                    action { println("Subjects Button pressed!")
                        workspace.dock<SubjectView>()}


                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                }
                button("People") {

                    action { println("People Button pressed!")
                        workspace.dock<PeopleView>()}


                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                }
                button("Pool") {

                    action { println("Pool Button pressed!")
                        workspace.dock<PoolView>()}


                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                }

                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }

            }

            top = vbox{
                setPrefSize(100.0, 30.0)

                useMaxWidth = true

                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }
            }


            center = vbox{
                setPrefSize(100.0, 960.0)
                style{
                    backgroundColor += Color.rgb(20, 31, 38)
                }
                vbox {
                    label ("Pool"){

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
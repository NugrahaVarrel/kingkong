import service.ActionService

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val service = ActionService()

    service.createData( "Singa", "mamalia", 5)
    service.createData( "Elang", "burung", 2)
    service.createData( "Ular", "reptil", 4)
    service.createData("Lumba", "MAMALIA", 12)

    service.addFeedSchedule(1, 9)
    service.addFeedSchedule(2, 7)
    service.addFeedSchedule(3, 10)
    service.addFeedSchedule(5, 12)

    println()
    service.soundParade()

    println()
    service.getAllAnimal()

    println()
    service.report()

}
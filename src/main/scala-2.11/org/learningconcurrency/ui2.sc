trait Clickable {
  def click()
}

abstract class Widget


trait Subject {
  type Observer = {def receiveUpdate(subject: Any)}

  private var observers = List[Observer]()

  def addObserver(observer: Observer) = observers ::= observer

  def notifyObservers = observers foreach (_.receiveUpdate(this))
}

class Button(val label: String) extends Widget with Clickable {
  override def click(): Unit = {}
}

trait ObservableClicks extends Clickable with Subject {
  abstract override def click() = {
    super.click()
    notifyObservers
  }
}

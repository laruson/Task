package andrey.chernikovich.softteco.presentation.base.pager

abstract class BasePagerViewModel<Entity> {
    abstract fun bind(listEntity: List<Entity>, position:Int)

    open fun onItemClick(){

    }
}
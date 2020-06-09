package mvp

interface OneContract {


    interface View {
        fun showData(data: String) {}
    }

    interface Presenter {

        fun getApiData(position: Int)

    }


}
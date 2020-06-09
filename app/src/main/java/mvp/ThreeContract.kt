package mvp

interface ThreeContract {

    interface View {
        fun showData(data: String) {}
    }

    interface Presenter {

        fun getApiData(position: Int)

    }


}
package mvp

interface Constract {


    interface View {
        fun showData(data: String) {}
    }

    interface Presenter {

        fun getApiData(position: Int)

    }


}
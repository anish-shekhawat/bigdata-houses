# Home Price Statistics using MapReduce [![LICENSE](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/anish-shekhawat/bigdata-kafka#license)

The objective of this program is to write a mapper and reducer to calculate the minimum, maximum, and mean price of the homes in each neighborhood represented in the data set.

The data is from a Kaggle [competition](https://www.kaggle.com/c/house-prices-advanced-regression-techniques/data).


## Installation

Download & configure MapR Sandbox

1. Download the MapRSandbox from [MapR](https://www.mapr.com/products/mapr-sandbox-hadoop/download)
2. Follow the instructions from [here](http://maprdocs.mapr.com/home/SandboxHadoop/c_sandbox_overview.html) to install and configure the sandbox.

## Usage

* Login to Sandbox as user01 user.
```bash
ssh -p 2222 user01@localhost
```
* Clone this repository
```bash
git clone https://github.com/anish-shekhawat/bigdata-houses.git
```
* Build the project
```bash
cd ~/bigdata-enron
./rebuild.sh
```
* Run the Project
```bash
./rerun.sh
```
    
## Contributing

#### Bug Reports & Feature Requests

Please use the [issue tracker](https://github.com/anish-shekhawat/bigdata-kafka/issues) to report any bugs or file feature requests.

#### Developing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request.

## License

>You can check out the full license [here](https://github.com/anish-shekhawat/bigdata-kafka/blob/master/LICENSE)

This project is licensed under the terms of the **MIT** license.

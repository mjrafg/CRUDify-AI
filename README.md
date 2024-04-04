## Getting Started

Before diving into "CRUDify AI," ensure IntelliJ IDEA is installed and you have an OpenAI account for obtaining a ChatGPT API key.

### Installation

1. **Install "CRUDify AI" Plugin:**
   - Open IntelliJ IDEA.
   - Go to `Settings > Plugins`.
   - Search for "CRUDify AI" in the Marketplace and click `Install`.

### Configure Plugin Settings

Post-installation, configure the plugin by setting your ChatGPT API key and specifying the paths to the generic classes your project uses. "CRUDify AI" generates code that extends these generic classes, integrating smoothly into your application architecture.

1. **Set the ChatGPT API Key:**
   - Access `File > Settings` (Windows/Linux) or `IntelliJ IDEA > Preferences` (macOS).
   - Locate the "CRUDify AI" plugin settings.
   - Enter your ChatGPT API key in the appropriate field.

2. **Define Paths to Generic Classes:**
   - In the plugin settings, specify the paths to the generic classes. This step is crucial as the CRUD functionality "CRUDify AI" generates will extend these base classes, ensuring your project maintains a consistent structure and functionality.
     - **Generic Entity Class Path**: Specify the path to the generic entity class that your generated entities will extend.
     - **Generic Controller Class Path**: Specify the path to the generic controller class that your generated controllers will extend.
     - **Generic Service Class Path**: Specify the path to the generic service class that your generated services will extend.
     - **Generic Repository Class Path**: Specify the path to the generic repository class that your generated repositories will extend.

### Usage

With "CRUDify AI" installed and correctly configured, generating CRUD functionalities is straightforward:

1. Right-click the directory in your project where you want to create the base CRUD pages.
2. Choose "CRUDify AI Create Base Page" from the context menu.
3. In the dialog window, enter the entity name and properties.
4. "CRUDify AI" will generate the necessary classes, extending from your specified generic classes, ready for CRUD operations.

## Contributing

We welcome contributions of all kinds from bug fixes to new features. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

MjrAfg - [mjrafg@yahoo.com](mjrafg@yahoo.com)

Project Link: [https://github.com/mjrafg/CRUDify-AI](https://github.com/mjrafg/CRUDify-AI)
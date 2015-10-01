package com.JavaQues;

class PurposeCodeGIBTransactionUtil{
	enum TypeName { PP,ACH }
	enum LangCode { EN,IW,ES,ZH,ZH_TW,SK,KK,RU }

	static String getTypeCode(final String paymentType, final String langCode, final String countryCode){
		String purcode;
		switch(TypeName.valueOf(paymentType)){

			case PP:
				switch(LangCode.valueOf(langCode)){
					case EN:
						purcode=PP.EN.fromString(countryCode);
						break;

					case IW:
						purcode=PP.IW.fromString(countryCode);
						break;

					case ES:
						purcode=PP.ES.fromString(countryCode);
						break;

					case ZH:
						purcode=PP.ZH.fromString(countryCode);
						break;

					case ZH_TW:
						purcode=PP.ZH_TW.fromString(countryCode);
						break;

					case SK:
						purcode=PP.SK.fromString(countryCode);
						break;

					case KK:
						purcode=PP.KK.fromString(countryCode);
						break;

					case RU:
						purcode=PP.RU.fromString(countryCode);
						break;

					default:
						purcode=PP.EN.fromString(countryCode);
				}
				break;

			case ACH:
				purcode="";
				break;
			default:
				purcode=PP.EN.fromString(countryCode);
		}

		if(purcode.equals("")) {
			purcode=PP.EN.fromString(countryCode);
		}

		return purcode;
	}

	private enum PP{
		Default;
		enum EN{
			IL("ILPP_EN"),
			CZ("CZPP_EN"),
			CL("CLPP_EN"),
			BN("BNPP_EN"),
			SK("SKPP_EN"),
			CN("CN_EN"),
			MY("MYPP"),
			KZ("KZKNP_EN"),
			ZN("ZAPP_EN");

			private final String type;
			private EN(final String type) {
				this.type=type;
			}

			static String fromString(final String string) {
				if (string != null) {

					for (final EN key : EN.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}

		enum IW{
			IL("ILPP_IW");

			private final String type;
			private IW(final String type) {
				this.type=type;
			}

			static String fromString(final String string) {
				if (string != null) {

					for (final IW key : IW.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
		enum ES{
			CZ("CZPP_ES"),
			CL("CLPP_ES");

			private final String type;
			private ES(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final ES key : ES.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}

		}
		enum ZH{
			CN("CN_ZH");

			private final String type;
			private ZH(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final ZH key : ZH.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
		enum ZH_TW{
			CN("CN_ZH_TW");
			private final String type;
			private ZH_TW(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final ZH_TW key : ZH_TW.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
					return "";
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
		enum SK{
			SK("SKPP_SK");
			private final String type;
			private SK(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final SK key : SK.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
		enum KK{
			KK("SKPP_KK");
			private final String type;
			private KK(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final KK key : KK.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
		enum RU{
			RU("SKPP_RU");
			private final String type;
			private RU(final String type) {
				this.type=type;
			}
			static String fromString(final String string) {
				if (string != null) {

					for (final RU key : RU.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
	}

	private enum ACH{
		Default;
		enum EN{

		}
	}

}

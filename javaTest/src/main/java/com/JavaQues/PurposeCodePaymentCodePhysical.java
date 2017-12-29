package com.JavaQues;

class PurposeCodePaymentCodePhysical{

	enum TypeName { PP,ACH }
	enum LangCode { EN,IW,ES,ZH,ZH_TW,SK,KK,RU }

	static String getTypeCode(final String paymentType, final String countryCode){
		String purcode;

		switch(TypeName.valueOf(paymentType)){

			case PP:
				purcode=ABC.PP.fromString(countryCode);
				break;

			case ACH:
				purcode=ABC.ACH.fromString(countryCode);
				break;

			default:
				purcode=ABC.PP.fromString(countryCode);
		}
		if(purcode.equals("")) {
			purcode=ABC.PP.fromString(countryCode);
		}
		return purcode;
	}

	enum ABC{

		Default;
		enum PP
		{
			SG("PURCODSG"),
			BR("GPSCOD"),
			DZ("PURCODEN"),
			QA("PURCODEN"),
			KW("PURCODEN"),
			AE("PURCODED");

			String type;

			private PP(final String type) {
				this.type=type;
			}

			static String fromString(final String string) {
				if (string != null) {

					for (final PP key : PP.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}

		enum ACH{
			SG("PUDSGACH");

			String type;

			private ACH(final String type) {
				this.type=type;
			}

			static String fromString(final String string) {
				if (string != null) {
					for (final ACH key : ACH.values()) {
						if (string.equalsIgnoreCase(key.name())) {
							return key.type;
						}
					}
					return "";
				}
				throw new IllegalArgumentException("Invalid value " + string + " for ModelMapKeys ");
			}
		}
	}
}

